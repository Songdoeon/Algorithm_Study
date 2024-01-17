#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int res[100][100];


void func(vector<vector<int>> v, int source, int idx){

    bool visited[100] = {0,};
    visited[idx] = 1;
    
    queue<int> q;
    q.push(idx);
    
    while(!q.empty()){
        int cur = q.front();
        q.pop();
        
        for(int i=0; i<v[cur].size(); i++){
            int nidx = v[cur][i];
            if(!visited[nidx]){
                visited[nidx] = true;
                res[source][nidx] = 1;
                // res[nidx][source] = 1;
                q.push(nidx);
            }
        }
    }
}

int main(){
    
    int N;  cin >> N;
    
    vector<vector<int>> v(N);
    
    for(int i=0; i<N; i++){
        for(int j=0; j<N; j++){
            int tmp;    cin >> tmp;
            if(tmp){
                v[i].push_back(j);
                res[i][j] = 1;
                // res[j][i] = 1;
            }
            // if(i == j)
            //     res[i][j] = 1;
        }
    }

    for(int i=0; i<N; i++){
        for(int j=0; j<v[i].size(); j++){
            int idx = v[i][j];
            func(v, i, idx);
        }
    }
    
    for(int i=0; i<N; i++){
        for(int j=0; j<N; j++){
            cout << res[i][j] << " ";
        }
        cout << "\n";
    }

    return 0;
}
