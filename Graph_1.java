package java2021;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Graph_1 {
	private ArrayList<ArrayList<Integer>> adj;
	private int vertex;
	
	public Graph_1(int vertex)
	{
		this.vertex = vertex;
		adj = new ArrayList<ArrayList<Integer>>(vertex);
		for(int i=0; i<vertex; i++)
			adj.add(new ArrayList<Integer>());
	}
	
	public void addEdge(int u, int v) {
		adj.get(u).add(v);
		adj.get(v).add(u);
	}
	
	public void bfs(int source)
	{
		boolean[] visited = new boolean[vertex];
		for(int i=0; i<vertex; i++)
		{
			visited[i] = false;
		}
		LinkedList<Integer> q = new LinkedList<Integer>();
		visited[source] = true;
		q.add(source);
		while(q.size()!=0) {
			int node = q.poll();
			System.out.print(node+ " ");
			Iterator<Integer> it = adj.get(source).iterator();
			while(it.hasNext()) {
				int n = it.next();
				if(!visited[n])
				{
					visited[n] = true;
					q.add(n);
				}
			}
		}
		System.out.println();
	}
	
	public void dfsUtil(int source, boolean[] visited)
	{
		visited[source] = true;
		System.out.print(source+" ");
		Iterator<Integer> it = adj.get(source).iterator();
		while(it.hasNext()) {
			int item = it.next();
			if(!visited[item]) {
				dfsUtil(item, visited);
			}
		}
		System.out.println();
	}
	
	public void dfs() {
		boolean[] visited = new boolean[vertex];
		for(int i=0; i<vertex; i++)
			if(!visited[i])
				dfsUtil(i, visited);
	}
	
	public static void main(String[] args) {
		Graph_1 g = new Graph_1(4);
		g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        System.out.println("< - BFS - >\n");
        g.bfs(2);
        System.out.println("\n< - DFS - >\n");
        g.dfs();
	}
}
