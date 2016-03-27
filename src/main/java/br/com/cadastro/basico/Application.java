package br.com.cadastro.basico;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;


@SpringBootApplication()
public class Application {

    private static SpringApplication app;


    public static void main(String[] args) {
        app = new SpringApplication(Application.class);

        app.run(args);
    }

    @Bean
    public ModelMapper criandoModelMapper() {
        ModelMapper mapeador = new ModelMapper();

        mapeador.getConfiguration().setPropertyCondition(context -> {

            if (context.getDestinationType().equals(context.getParent().getDestinationType())) {
                return false;
            } else if (context.getDestinationType().equals(List.class) && ((List) context.getSource()).size() != 0) {
                Object o = ((List) context.getSource()).get(0);

                return context.getParent().getDestinationType().equals(o.getClass());
            }

            return true;
        });

        return mapeador;
    }
}
