package org.fugerit.java.demo.lab.broken.access.control;

import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import lombok.extern.slf4j.Slf4j;
import io.quarkus.runtime.annotations.RegisterForReflection;
import org.fugerit.java.core.function.SafeFunction;
import org.fugerit.java.doc.base.config.InitHandler;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

@Slf4j
@ApplicationScoped
@RegisterForReflection(targets = { DocHelper.class, People.class })
public class AppInit {

    DocHelper docHelper;

    public AppInit(DocHelper docHelper) {
        this.docHelper = docHelper;
    }

    private void initDb() {
        SafeFunction.apply(() -> {
            String url = "jdbc:h2:mem:labbac;DB_CLOSE_DELAY=-1;MODE=Oracle;INIT=RUNSCRIPT FROM './src/test/resources/h2init/init.sql';";
            try (Connection conn = DriverManager.getConnection(url)) {
                DatabaseMetaData meta = conn.getMetaData();
                log.info("Connected to database '{} - {}'", meta.getDatabaseProductName(), meta.getDatabaseProductVersion());
            }
        });
    }

    void onStart(@Observes StartupEvent ev) {
        log.info("L'applicazione si sta avviando...");
        /*
         * This will initialize all the doc handlers using async mode.
         * (use method InitHandler.initDocAll() for synced startup)
         */
        InitHandler.initDocAllAsync(
                docHelper.getDocProcessConfig().getFacade().handlers());
        initDb();
        log.info("Avvio terminato.");
    }

}
