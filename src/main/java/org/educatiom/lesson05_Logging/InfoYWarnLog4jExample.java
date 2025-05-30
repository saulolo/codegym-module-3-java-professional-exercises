package org.educatiom.lesson05_Logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class InfoYWarnLog4jExample {

    private static final Logger logger = LoggerFactory.getLogger(InfoYWarnLog4jExample.class);

    public boolean processTask(Task task) {
        logger.info("processTask id = " + task.getId());
        logger.warn("processTask id = " + task.toString());
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
