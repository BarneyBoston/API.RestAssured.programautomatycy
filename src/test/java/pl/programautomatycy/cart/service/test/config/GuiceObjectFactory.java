package pl.programautomatycy.cart.service.test.config;

import com.google.inject.Guice;
import com.google.inject.Injector;
import io.cucumber.core.backend.ObjectFactory;
import pl.programautomatycy.api.configuration.ProgramAutomatycyConfiguration;

public class GuiceObjectFactory implements ObjectFactory {
    private final Injector injector;

    public GuiceObjectFactory() {
        this.injector = Guice.createInjector(new ProgramAutomatycyConfiguration());
    }

    @Override
    public void start() {
    }

    @Override
    public void stop() {
    }

    @Override
    public boolean addClass(Class<?> glueClass) {
        return true;
    }

    @Override
    public <T> T getInstance(Class<T> glueClass) {
        return injector.getInstance(glueClass);
    }
}
