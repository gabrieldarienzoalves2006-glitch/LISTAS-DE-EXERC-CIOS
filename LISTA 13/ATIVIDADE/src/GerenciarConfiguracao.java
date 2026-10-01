public class GerenciarConfiguracao {


private String apiKey = "AWS-12345-KEY";


private GerenciarConfiguracao() {
}

private static GerenciarConfiguracao instancia;

public static GerenciarConfiguracao getInstancia() {
    if (instancia == null) {
        instancia = new GerenciarConfiguracao();
    }
    return instancia;
}

public String getApiKey() {
    return apiKey;

}

}