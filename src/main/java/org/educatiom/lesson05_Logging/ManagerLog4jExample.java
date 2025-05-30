package org.educatiom.lesson05_Logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ManagerLog4jExample {

    //Ojo, este es el primer Logging de Java, ya hay mas actuales y mejores
    private static final Logger logger = LoggerFactory.getLogger(ManagerLog4jExample.class);

    public boolean processTask(Task task) {
        logger.debug("processTask id = {}", task.getId());
        try {
            task.start();
            task.progress();
            task.complete();
            return true;
        } catch (Exception e) {
            logger.error("Error desconocido al procesar tarea.", e);
            return false;
        }
    }


    private class Task {
         private String id;

        public Task(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void start() {
        }

        public void progress() {
        }

        public void complete() {
        }
    }
}
