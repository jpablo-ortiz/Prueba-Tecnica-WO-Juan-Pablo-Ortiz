package com.empresa.Prueba.Tecnica.auxiliar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Esta clase implementa métodos estáticos para levantar distintos tipos de logs en consola.
 *
 * @author Juan Pablo Ortiz
 * @version 1.0
 */
public class LoggerLog4j {
    /**
     * Logger para seguimiento del controlador por la consola de Spring.
     */
    private static final Logger logger = LogManager.getLogger(OnBoot.class.getName());

    
    /** 
     * Método que levanta un log de tipo INFO con el mensaje recibido.
     * @param mensaje Mensaje de información.
     */
    public static void info(String mensaje)
    {
        logger.info(mensaje);
    }

    
    /** 
     * Método que levanta un log de tipo WARN con el mensaje recibido.
     * @param mensaje Mensaje de advertencia.
     */
    public static void warning(String mensaje)
    {
        logger.warn(mensaje);
    }

    
    /** 
     * Método que levanta un log de tipo ERROR con el mensaje recibido.
     * @param mensaje Mensaje de error.
     */
    public static void error(String mensaje)
    {
        logger.error(mensaje);
    }
}
