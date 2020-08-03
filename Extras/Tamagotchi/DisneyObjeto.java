
public class DisneyObjeto {
    
    private int hambre, felicidad, sueno, higiene, vida;
    private String  nombre;
    
    
    //Creación de mi objeto
        public DisneyObjeto ( )
        {
                hambre= 100; 
                felicidad = 25;
                sueno= 75;
                higiene = 50;
                vida = 80;
        }
        public DisneyObjeto (int h, int v, int hi, int s, int f)
        {
            hambre = h;
            vida = v;
            higiene = hi;
            sueno = s;
            felicidad = f;
        }

    //Creación de los SETS y los GETS
         public void setVida(int v)
        {
            vida = v;
        }

        public int getVida ()
        {
            return vida;
        }
        
        public void setHambre(int h)
        {
            hambre = h;
        }

        public int getHambre ()
        {
            return hambre;
        }

        public void setFelicidad (int f)
        {
            felicidad =  f;
        }

        public int getFelicidad ()
        {
            return felicidad;
        }

        public void setSueno (int s)
        {
            sueno = s;
        }

        public int getSueno()
        {
            return sueno;
        }

        public void setHigiene(int hi)
        {
            higiene = hi;
        }

        public int getHigiene()
        {
            return higiene;
        }

        public void setNombre (String n)
        {
            nombre = n;
        }

        public String getNombre ()
        {
            return nombre;
        }
    
}
