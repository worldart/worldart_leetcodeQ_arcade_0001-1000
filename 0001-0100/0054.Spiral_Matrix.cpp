//100%RT

class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>>& matriz) {

        int N=matriz.size();
        int M=matriz[0].size();
        

        int derecha = 0;
        int izquierda = N - 1;
        int arriba = 0;
        int abajo = M - 1;

        
        int total=N*M;

        vector<int> response;
        int cont=0;

        while (cont<N*M) {
                //Recorrido Hacia la derecha.	
                for (int j = arriba; j <= abajo && cont<total; j++){
                    response.push_back(matriz[derecha][j]);
                    cont++;
                } 
                derecha++;

                //Recorrido Hacia Abajo.
                for (int i = derecha; i <= izquierda  && cont<total; i++)  {
                    response.push_back(matriz[i][abajo]);
                    cont++;
                }          
                abajo--;
                
                //Hacia la izquierda.
                for (int j = abajo; j >= arriba  && cont<total; j--) {
                    response.push_back(matriz[izquierda][j]);
                    cont++;
                }     
                izquierda--;
                
                //Recorrido Hacia arriba.
                for (int i = izquierda; i >= derecha  && cont<total; i--){
                    response.push_back(matriz[i][arriba]);
                    cont++;
                }            
                arriba++;
        }
        
        return response;
    };
};
