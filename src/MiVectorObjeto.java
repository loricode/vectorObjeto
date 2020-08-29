
import javax.swing.JOptionPane;


public class MiVectorObjeto {

  
   public static void main(String[] args) {
     
      Logica miobj =  new Logica();
      byte opc;
      do{
         opc = Byte.parseByte(JOptionPane.showInputDialog(
                  "Menu Principal\n"
                 + "1. Crear y Registrar Empleados \n"
                 + "2. Buscar por id\n"
                 + "3. listar Quicksort\n"
                 + "4. ordenamiento Seleccion\n"
                 + "5. Ordenamiento Shell\n"
                 + "6. Exit" ));
         
         switch(opc){

            case 1:
                  miobj.addEmpleado();
                 break;
                 
            case 2:
                 String id = JOptionPane.showInputDialog("DIGITE ID A BUSCAR");
                 miobj.buscarEmpleadoId(id);
                 break;

            case 3:
                  miobj.listarQuicksort();
                 break;
                 
            case 4:
                    miobj.seleccion();
                    miobj.listar();
                 break;
                 
                 
            case 5:
                  miobj.ordenamientoShell();
                  miobj.listar();
                 break;
                 
           case 6:   
                 JOptionPane.showMessageDialog(null, "chao");
                 break;      
         }
         
      }while(opc!=6);
      System.exit(0);
   }
   
}
