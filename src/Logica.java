
import javax.swing.JOptionPane;


public class Logica {

  private Empleado vector[];
   private int tamanio;
   
  public Logica(){
     tamanio = 0;
     vector = null;
  }
  
  
  public void  setTamanio(int tam){
     tamanio = tam;
  }
  public int getTamanio(){
     return tamanio;
  }
  
  public String Input(String texto){
     return JOptionPane.showInputDialog(texto);
  }
  
  public void addEmpleado(){
      
     setTamanio(Integer.parseInt(Input("CANTIDAD DE EMPLEADOS A GUARDAR:")));
     int tam = getTamanio();  
     vector = new Empleado[tam];
     
     for( int i=0; i<tamanio; i++ ){
        
        Empleado obj = new Empleado(); 
        obj.setIDEMPLEADO(Input("DIGITE ID"));
        obj.setNOMBRE(Input("DIGITE NOMBRE"));
        obj.setSALARIO(Float.parseFloat(Input("DIGITE SALARIO")));
        obj.setESTRATO(Integer.parseInt(Input("DIGITE ESTRATO")));
        obj.setHE(Integer.parseInt(Input("DIGITE HORAS EXTRAS")));
        obj.setFE(Input("DIGITE LA FECHA DE VINCULACION"));
        
        vector[i] = obj; 
     }
  }
  
  public void buscarEmpleadoId(String id){
     String lista = "";
     for( int i=0; i<tamanio; i++ ){
        if(id.equals(vector[i].getIDEMPLEADO())){
           lista+="ID: "+vector[i].getIDEMPLEADO()+"\n"; 
           lista+="NOMBRE: "+vector[i].getNOMBRE()+"\n"; 
           lista+="SALARIO: "+vector[i].getSALARIO()+"\n";
           lista+="ESTRATO: "+vector[i].getESTRATO()+"\n";
           lista+="HE: "+vector[i].getHE()+"\n";
           lista+="FE: "+vector[i].getFE()+"\n"; 
           JOptionPane.showMessageDialog(null, lista);      
           return;
        }else{
           
        }
       JOptionPane.showMessageDialog(null, "no existe id");
       
     }
  }
     
  public void ordenamientoShell(){
     int i,j,d;
       d=(vector.length)/2;
     while(d>=1){
        for(i=d;i<vector.length;i++){
           j=i;
           while(j-d>=0){
              if(vector[j-d].getESTRATO()<vector[j].getESTRATO()){
                 Cambiar(j-d, j);
                 j=j-d;
              }
              else
                 break;
           }
        }
        d=d/2;
        
     }
   
   }
      
   public void Cambiar(int p1, int p2){
     Empleado nodo;
     nodo=vector[p1];
     vector[p1]=vector[p2];
     vector[p2]=nodo;
     
   }
   
  
  public void listar(){
     String lista = "";
     ordenamientoShell();
     for( int i=0; i<tamanio; i++ ){
           lista+="EMPLEADO # "+(i+1)+"\n";
           lista+="ID: "+vector[i].getIDEMPLEADO()+"\n"; 
           lista+="NOMBRE: "+vector[i].getNOMBRE()+"\n"; 
           lista+="SALARIO: "+vector[i].getSALARIO()+"\n";
           lista+="ESTRATO: "+vector[i].getESTRATO()+"\n";
           lista+="HE: "+vector[i].getHE()+"\n";
           lista+="FE: "+vector[i].getFE()+"\n\n"; 
         
         }
       JOptionPane.showMessageDialog(null, lista);
   
  }
  
  
  
  public void seleccion() {
          int i, j, pos, tmp;
          String menor;
          for (i = 0; i < vector.length - 1; i++) {   
                menor = vector[i].getNOMBRE();                                          
                pos = i;                            
                for (j = i + 1; j < vector.length; j++){  
                      if (vector[j].getNOMBRE().compareTo(menor) > 0 ) {    
                          menor = vector[j].getNOMBRE();             
                          pos = j;
                      }
                }
                if (pos != i){                                              
                    Cambiar(i,pos);
                }
          }
}


}    
  
  

