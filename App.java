public class App {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Piloto> pilotos = new ArrayList<>();  

    public static void main(String[] args) throws InterruptedException, IOException {
        Scanner in = new Scanner(System.in);
        int opcao = 0;

        do {
            System.out.println("\n MENU \n");
            System.out.println("1 - Cadastrar o piloto");
            System.out.println("2 - Listar os pilotos cadastrados");
            System.out.println("3 - Localizar o piloto por meio do CPF");
            System.out.println("0 - Sair");
            System.out.print("Opção:");
            opcao = scanner.nextInt();
            
            if (opcao >= 1 && opcao <= 9) {

                switch (opcao) {
                    case 1: {
                        cadastrarPiloto();
                        voltarMenu(in);
                    }
                    case 2: {
                        listarPilotos();
                        voltarMenu(in);
                    }
                    case 3: {
                        System.out.println("Buscar CPF: ");
                        String pesquisarCpf = scanner.next();
                        buscarPilotos(pesquisarCpf);
                        voltarMenu(in);
                    }
                    default: {
                        System.out.println("Ainda não realizado");
                        voltarMenu(in);
                    }
                }
            }else {
                System.out.println("opção não válida");  
            }
        } while (opcao != 0);

        System.out.println("Acabou o programa!");

        in.close();
    }

    private static void cadastrarPiloto() {
        System.out.println("Cadastro de Pilotos");
        System.out.println("Nome: ");
        String nome = scanner.next();
        System.out.println("CPF: ");
        String cpf = scanner.next();
       
        Piloto piloto = new Piloto(nome, cpf, matricula);
        pilotos.add(piloto);
        System.out.println("Piloto CPF: " + piloto.get_cpf ());
    }

    private static void listarPilotos() {
        if (pilotos.isEmpty()) {
            System.out.println("Nenhum piloto foi cadastrado no sistema até o momento.");
        }else {
        
            System.out.println("Lista de Pilotos cadastrados:");
            for (int i = 0; i < pilotos.size(); i++) {
                System.out.println(pilotos.get(i));
            }
        }    
    }

    private static void buscarPilotos(String cpf) {
        
        
        for (Piloto piloto: pilotos) {  
            if (piloto.get_cpf().equals(cpf)) {
                System.out.println("*Piloto encontrado!*" + piloto);
               
            }else{
                System.out.println("Piloto não encontrado.");
                                
            }
        }
    }

    private static void voltarMenu(Scanner in) throws InterruptedException, IOException {
        System.out.println("\naperte ENTER para voltar ao menu.");
        in.nextLine();

        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            System.out.print("\033[H\033[2J");
        
        System.out.flush();
    }
}