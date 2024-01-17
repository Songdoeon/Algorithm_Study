#include <iostream>

using namespace std;

int arr[101][101];
bool visited[101][101];

int dr[] = {0, 0, -1, 1};
int dc[] = {1, -1, 0, 0};

int N, M, K;
int ans = 0;
int tmp = 0;

void dfs(int row, int col){
    tmp++;
    
    visited[row][col] = true;
        
    for(int i=0; i<4; i++){
        int nrow = row + dr[i];
        int ncol = col + dc[i];
        
        if(nrow <= 0 || nrow > N || ncol <=0 || ncol > M)
            continue;
            
        if(visited[nrow][ncol] || !arr[nrow][ncol])
            continue;
        
        dfs(nrow, ncol);
    }
}

int main(){
    
    cin >> N >> M >> K;
    
    for(int i=0; i<K; i++){
        int r, c;
        cin >> r >> c;
        arr[r][c] = 1;
    }
    
    for(int i=1; i<=N; i++){
        for(int j=1; j<=M; j++){
            tmp = 0;
            if(!visited[i][j] && arr[i][j]){
                //cout << "=======" << i << " " << j << endl;
                dfs(i, j);
            }
            if(ans < tmp)
                ans = tmp;
        }
    }
    
    cout << ans;

    return 0;
}
