package br.com.techcorp.model;

import java.util.Objects;

public class Funcionario {
      private String nome;
      private String matricula;
      private String cargo;


      public Funcionario(String matricula , String nome , String cargo){
      this.matricula = matricula;
      this.nome = nome;
      this.cargo = cargo;

      }
public String getmatricula(){
    return matricula;
}
public String getnome(){
    return nome;
}
public String getcargo(){
    return cargo;
}
public void setnome(String nome){
    this.nome = nome;
}
public void setmatricula(String matricula){
    this.matricula = matricula;
}
public void setcargo(String cargo){
    this.cargo = cargo;
}
@Override
public boolean equals(Object o){
    if (this == o) {
        return true;
    }
    if (o == null||getClass()!=o.getClass()) {
        return false;
    }
    Funcionario Funcionario = (Funcionario)o;
    return Objects.equals(matricula , Funcionario.matricula);
}
@Override
public int hashCode(){
    return Objects.hash(matricula);
}
@Override
public String toString(){
    return "Funcionario{" +
                "matricula='" + matricula + '\'' +
                ", nome='" + nome + '\'' +
                ", cargo='" + cargo + '\'' +
                '}';
}
}
