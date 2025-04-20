class Solution {
    int[][] _computers;
    int networks = 0;
    boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        _computers = computers;
        visited = new boolean[n];
        for (boolean v: visited) v = false;
        
        dfs();
        return networks;
    }
    
    private void dfs() {
        for(int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                networks++;
                visited[i] = true;
                _dfs(i);
            }
        }
    }
    
    private void _dfs(int index) {
        for (int i = 0; i < _computers.length; i++) {
            if (_computers[index][i] == 1 && !visited[i]) {
                visited[i] = true;
                _dfs(i);
            }
        }
    }
}