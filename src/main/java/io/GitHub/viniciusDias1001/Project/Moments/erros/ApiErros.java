package io.GitHub.viniciusDias1001.Project.Moments.erros;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@Data
@NoArgsConstructor
public class ApiErros {
    private List<String> erros;

    public ApiErros(String mensagemErros){
        this.erros = Arrays.asList(mensagemErros);
    }

    public ApiErros(List<String> list){
        this.erros = list;
    }

    public List<String> getErros() {
        return erros;
    }

    public void setErros(List<String> erros) {
        this.erros = erros;
    }

    @Override
    public String toString() {
        return "ApiErros{" +
                "erros=" + erros +
                '}';
    }
}
