package mythossaga;

public class menu {
    // La clase se encargará de mostrar el menú principal, con todas las opciones que un usuario puede realizar

       public void pantallaInicial() throws Exception{
            Database data;
            Sistema sistema = new Sistema();
            Integer opcion = 0;
            Scanner input = new Scanner(System.in);
            File file = new File("data/database.data");

            if(file.exists()) {
                data = this.loadData();
            } else {
                data = new Database();
                data.inicializarPersonajes();
            }
            while (opcion != 4){
                System.out.println("-----------------------");
                System.out.println("  MYTHOSSAGA ");
                System.out.println("-----------------------");
                System.out.println("INTRODUZCA OPCION :");
                System.out.println("1.- Iniciar Sesion");
                System.out.println("2.- Registrarse");
                System.out.println("3.- Darse de baja");
                System.out.println("4.- Salir del sistema");
                opcion = input.nextInt();
                switch (opcion){
                    case 1: sistema.logIn(data);
                        break;

                    case 2: sistema.registro(data);
                        break;

                    case 3: sistema.darDeBaja(data);
                        break;

                    default: break;
                }
                data.saveData();
            }
        }

        // Esta función se encargará de cargar los datos del archivo binario
        public Database loadData() throws FileNotFoundException, IOException, ClassNotFoundException {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("data/database.data"));
            Database data = (Database) in.readObject();
            in.close();
            return data;
        } 
}

