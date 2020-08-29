
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
        obj.setFE(Integer.parseInt(Input("DIGITE LA FECHA DE VINCULACION")));
        
        vector[i] = obj; 
     }
  }
  
  public void buscarEmpleadoId(String id){
     String lista = "";
     
     float salud = 0, pension=0, ARL = 0, horaExtra=0, subsidio=0; 
     for( int i=0; i<tamanio; i++ ){
        if(id.equals(vector[i].getIDEMPLEADO())){
           
           salud+= vector[i].getSALARIO()*0.4;
           pension+= vector[i].getSALARIO()*0.375;
           ARL+= vector[i].getSALARIO()*0.2;
           
           if(vector[i].getFE()>10) horaExtra=45000;
              
           if(vector[i].getFE()>=5&&vector[i].getFE()<=10)horaExtra=35000;
           
           if(vector[i].getFE()>=3&&vector[i].getFE()<=5)horaExtra=30000;
           
           if(vector[i].getFE()<3)horaExtra=25000;
           
           if(vector[i].getFE()>0&&vector[i].getFE()<=2)subsidio=75000;
           
           lista+="ID: "+vector[i].getIDEMPLEADO()+"\n"; 
           lista+="NOMBRE: "+vector[i].getNOMBRE()+"\n";
           lista+="SALARIO: "+vector[i].getSALARIO()+"\n";
           lista+="ESTRATO: "+vector[i].getESTRATO()+"\n";
           lista+="valor HE: "+horaExtra+"\n";
           lista+="aporte a la salud : "+salud+"\n";
           lista+="aporte a la pension : "+pension+"\n";
           lista+="aporte a la ARL : "+ARL+"\n";
           lista+="subsidio de transporte : "+subsidio+"\n";
           lista+="HE: "+vector[i].getHE()+"\n";
           lista+="FE: "+vector[i].getFE()+"\n"; 
           lista+="NETO: "+((vector[i].getSALARIO()*horaExtra)-salud-pension-ARL+subsidio)+"\n";
            
           JOptionPane.showMessageDialog(null, lista+salud);      
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
  
  public void listarQuicksort(){
     String lista = "";
     quicksort(0, vector.length-1);
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


  public void quicksort( int izq, int der) {

  float pivote = vector[izq].getSALARIO(); 
  int i=izq;         
  int j=der;         
  Empleado aux;
 
  while(i < j){                                                          
     while(vector[i].getSALARIO() <= pivote && i < j) i++; 
     while(vector[j].getSALARIO() > pivote) j--;           
     if (i > j) {                                             
         aux= vector[i];                      
         vector[i]=vector[j];
         vector[j]=aux;
     }
   }
   
   vector[izq]=vector[j];  
                                     
                         
   
   if(izq < j-1)
      quicksort(izq,j-1);          
   if(j+1 < der)
      quicksort(j+1,der);          
   
}
  
}
   
  
  
  

