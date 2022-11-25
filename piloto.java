public class Piloto {
    private String nome;
    private String cpf;
    private String matricula;
   

    public Piloto (String nome, String cpf, String matricula) {
        nome = nome;
        cpf = cpf;   
        matricula = matricula;
    }

    public String getnome() {
        return nome;
    }
    public String getcpf() {
        return cpf;
    }
    public String getmatricula() {
    }
   
    
    @Override
    public String toString(){
        return "Nome: " + nome + " CPF: " + cpf + "Matricula:" + matricula;
    }
    
}
