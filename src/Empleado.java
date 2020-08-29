
public class Empleado {
  //atributos de la clase
  public String IDEMPLEADO;
  public String NOMBRE;
  public float SALARIO;
  public int ESTRATO;
  public int HE; //hora extras laboradas
  public int FE; //fecha de vinculacion
  public float neto;
  //constructor
  public Empleado(){
   
    IDEMPLEADO = "";
    NOMBRE = "";
    SALARIO = 0;
    ESTRATO = 0;
    HE = 0;
    FE = 0;
    neto=0;
}

   public float getNeto() {
      return neto;
   }

   public void setNeto(float neto) {
      this.neto = neto;
   }


   public String getIDEMPLEADO() {
      return IDEMPLEADO;
   }

   public void setIDEMPLEADO(String IDEMPLEADO) {
      this.IDEMPLEADO = IDEMPLEADO;
   }

   public String getNOMBRE() {
      return NOMBRE;
   }

   public void setNOMBRE(String NOMBRE) {
      this.NOMBRE = NOMBRE;
   }

   public float getSALARIO() {
      return SALARIO;
   }

   public void setSALARIO(float SALARIO) {
      this.SALARIO = SALARIO;
   }

   public int getESTRATO() {
      return ESTRATO;
   }

   public void setESTRATO(int ESTRATO) {
      this.ESTRATO = ESTRATO;
   }

   public int getHE() {
      return HE;
   }

   public void setHE(int HE) {
      this.HE = HE;
   }

   public int getFE() {
      return FE;
   }

   public void setFE(int FE) {
      this.FE = FE;
   }  
   
}//fin de la clase Empleado
