public class Funcionario {

    private String matricula;
    private String nome;
    private departamento: Departamento;

    Funcionario(String matriculo, String nome, depto: Departamento);
    

    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    @Override
    public String toString() {
        return "Funcionario [matricula=" + matricula + ", nome=" + nome + "]";
    }

}