package dfs;

import java.util.PriorityQueue;

public class NetworkDelay {
    public int networkDelayTime(int[][] times, int N, int K)
    {
        int edges[][]=new int[N+1][N+1];
        int dist[]=new int[N+1]; // keep track of minimum dist from K to i
        for(int i=0;i<=N;i++){
            for(int j=0;j<=N;j++){
                edges[i][j]=-1;
            }
            dist[i]=Integer.MAX_VALUE;
        }

        for(int i=0;i<times.length;i++)
        {
            int start=times[i][0];
            int end=times[i][1];
            edges[start][end]=times[i][2];
        }

        PriorityQueue<Integer>pq=new PriorityQueue<>((a,b)->dist[a]-dist[b]);// keep the i with minimum dist(K,i) at top
        dist[K]=0;
        pq.add(K);

        boolean visited[]=new boolean[N+1];

        int res=0;
        int count=0;
        while(!pq.isEmpty()){
            int cur = pq.remove();
            visited[cur]=true;



            count++;
            res = Math.max(dist[cur], res); // max of dist(K,1),dist(K,2),dist(K,3),dist(K,4)

            //for all neighbours
            for(int i=1;i<=N;i++){
                int distViaCur = dist[cur]+edges[cur][i];
                if(!visited[i] && edges[cur][i]!=-1 && dist[i]>=distViaCur){
                    dist[i] = distViaCur;
                    pq.add(i);
                }
            }
        }

        return res==Integer.MAX_VALUE||count<N?-1:res;
    }

    public int networkDelayTime2(int[][] times, int N, int K)
    {
        int edges[][]=new int[N+1][N+1];
        int dist[]=new int[N+1]; // keep track of minimum dist from K to i
        for(int i=0;i<=N;i++){
            for(int j=0;j<=N;j++){
                edges[i][j]=-1;
            }
            dist[i]=Integer.MAX_VALUE;
        }

        for(int i=0;i<times.length;i++)
        {
            int start=times[i][0];
            int end=times[i][1];
            edges[start][end]=times[i][2];
        }

        PriorityQueue<Integer>pq=new PriorityQueue<>((a,b)->dist[a]-dist[b]);// keep the i with minimum dist(K,i) at top
        dist[K]=0;
        pq.add(K);

        boolean visited[]=new boolean[N+1];

        int res=0;
        int count=0;
        while(!pq.isEmpty()){
            int cur = pq.remove();

            //update result
            count++;
            res = Math.max(dist[cur], res); // max of dist(K,1),dist(K,2),dist(K,3),dist(K,4)
            //visited[cur]=true;
            //update dist for all children
            for(int i=1;i<=N;i++){
                int distViaCur = dist[cur]+edges[cur][i];
                if(edges[cur][i]!=-1 && dist[i]>=distViaCur){
                    dist[i] = distViaCur;
                }
            }


            //for all neighbours
            for(int i=1;i<=N;i++){
                if(!visited[i] && edges[cur][i]!=-1 ){
                    pq.add(i);
                    visited[i] = true;
                }
            }
        }

        return res==Integer.MAX_VALUE||count<N?-1:res;
    }

    public static void main(String[] args) {
        //[[1,2,1],[2,3,7],[1,3,4],[2,1,2]]

        int[] t1 = new int[]{1,2,1};
        int[] t2 = new int[]{2,3,7};
        int[] t3 = new int[]{1,3,4};
        int[] t4 = new int[]{2,1,2};
        int[][] times = new int[][]{t1,t2,t3,t4};
        new NetworkDelay().networkDelayTime2(times, 4, 1);

    }
}
