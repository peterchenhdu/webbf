package cn.edu.hdu.webbf.common.log;

import org.slf4j.LoggerFactory;
import org.slf4j.helpers.MessageFormatter;

/**
 * Facade for SLF4J's logger.
 */

public class Logger
{
    private org.slf4j.Logger logger;

    /**
     * Default constructor
     * 
     * @param clazz Name of the class to log.
     */
    public Logger(Class<?> clazz)
    {
        this.logger = LoggerFactory.getLogger(clazz);
    }

    public Logger(String name)
    {
        this.logger = LoggerFactory.getLogger(name);
    }

    // static methods
    // -------------------------------------------------------------------------------------------------

    /**
     * Return a logger for a given class.
     * 
     * @param clazz Class.
     * 
     * @return Logger for a class.
     */
    public static Logger getLogger(Class<?> clazz)
    {
        return new Logger(clazz);
    }

    public static Logger getLogger(String name)
    {
        return new Logger(name);
    }

    // public methods
    // -------------------------------------------------------------------------------------------------

    /**
     * Return the name of the logger.
     * 
     * @return Name of the logger.
     */
    public String getName()
    {
        return this.logger.getName();
    }

    /**
     * Test whether trace logging level is enabled.
     * 
     * @return <code>true</code> if trace logging level is enabled,
     *         <code>false</code> otherwise.
     */
    public boolean isTraceEnabled()
    {
        return this.logger.isTraceEnabled();
    }

    /**
     * Print a trace message to the logs.
     * 
     * @param message Message to be logged.
     */
    public void trace(String message)
    {
        this.logger.trace(message);
    }

    /**
     * Print a formatted trace message to the logs, with one parameter.
     * 
     * @param message Message to be logged.
     * @param parameter Message parameter.
     */
    public void trace(String message, Object parameter)
    {
        this.logger.trace(message, parameter);
    }

    /**
     * Print a formatted trace message to the logs, with an arbitrary number of
     * parameters.
     * 
     * @param message Message to be logged.
     * @param parameters Array of parameters.
     */
    public void trace(String message, Object... parameters)
    {
        // This is where magic happens and syntax sugar is offered...
        // The interface overrides an Object[] and offers Object... instead!
        // Awesome, ain't it? No. It should come as standard in SLF4J.
        this.logger.trace(message, parameters);
    }

    /**
     * Print a trace message with an exception.
     * 
     * @param message Message to be logged.
     * @param throwable Throwable to be logged.
     */
    public void trace(String message, Throwable throwable)
    {
        this.logger.trace(message, throwable);
    }

    /**
     * Print a formatted trace message to the logs, with an arbitrary number of
     * parameters and an exception.
     * <p/>
     * In order for this to work a workaround has to be done, because SLF4J's
     * api only allows for exceptions to be logged alongside with a String, thus
     * disabling formatted message AND exception logging.<br/>
     * Resorting to SLF4J's MessageFormater to format the message with the
     * parameters into a string and then passing that string as the message, it
     * is possible to have the best of both worlds.<br/>
     * In order to avoid incurring the overhead of this process, before doing
     * it, a test to check if the log level is enabled is done.
     * <p/>
     * NOTE: The order of the throwable and object array is switched due to Java
     * language limitations, but the exception always shows up AFTER the
     * formatted message.
     * 
     * @param message Message to be formatted.
     * @param throwable Throwable to be logged.
     * @param parameters Parameters to format the message.
     */
    public void trace(String message, Throwable throwable, Object... parameters)
    {
        if (this.logger.isTraceEnabled())
        {
            this.logger.trace(MessageFormatter.arrayFormat(message, parameters).getMessage(),
                throwable);
        }
    }

    /**
     * Test whether debug logging level is enabled.
     * 
     * @return <code>true</code> if debug logging level is enabled,
     *         <code>false</code> otherwise.
     */
    public boolean isDebugEnabled()
    {
        return this.logger.isDebugEnabled();
    }

    /**
     * Print a debug message to the logs.
     * 
     * @param message Message to be logged.
     */
    public void debug(String message)
    {
        this.logger.debug(message);
    }

    /**
     * Print a formatted debug message to the logs, with one parameter.
     * 
     * @param message Message to be logged.
     * @param parameter Message parameter.
     */
    public void debug(String message, Object parameter)
    {
        this.logger.debug(message, parameter);
    }

    /**
     * Print a formatted debug message to the logs, with an arbitrary number of
     * parameters.
     * 
     * @param message Message to be logged.
     * @param parameters Array of parameters.
     */
    public void debug(String message, Object... parameters)
    {
        this.logger.debug(message, parameters);
    }

    /**
     * Print a debug message with an exception.
     * 
     * @param message Message to be logged.
     * @param throwable Throwable to be logged.
     */
    public void debug(String message, Throwable throwable)
    {
        this.logger.debug(message, throwable);
    }

    /**
     * Print a formatted debug message to the logs, with an arbitrary number of
     * parameters and an exception.
     * <p/>
     * In order for this to work a workaround has to be done, because SLF4J's
     * api only allows for exceptions to be logged alongside with a String, thus
     * disabling formatted message AND exception logging.<br/>
     * Resorting to SLF4J's MessageFormater to format the message with the
     * parameters into a string and then passing that string as the message, it
     * is possible to have the best of both worlds.<br/>
     * In order to avoid incurring the overhead of this process, before doing
     * it, a test to check if the log level is enabled is done.
     * <p/>
     * NOTE: The order of the throwable and object array is switched due to Java
     * language limitations, but the exception always shows up AFTER the
     * formatted message.
     * 
     * @param message Message to be formatted.
     * @param throwable Throwable to be logged.
     * @param parameters Parameters to format the message.
     */
    public void debug(String message, Throwable throwable, Object... parameters)
    {
        if (this.logger.isDebugEnabled())
        {
            this.logger.debug(MessageFormatter.arrayFormat(message, parameters).getMessage(),
                throwable);
        }
    }

    /**
     * Test whether info logging level is enabled.
     * 
     * @return <code>true</code> if info logging level is enabled,
     *         <code>false</code> otherwise.
     */
    public boolean isInfoEnabled()
    {
        return this.logger.isInfoEnabled();
    }

    /**
     * Print a info message to the logs.
     * 
     * @param message Message to be logged.
     */
    public void info(String message)
    {
        this.logger.info(message);
    }

    /**
     * Print a formatted info message to the logs, with one parameter.
     * 
     * @param message Message to be logged.
     * @param parameter Message parameter.
     */
    public void info(String message, Object parameter)
    {
        this.logger.info(message, parameter);
    }

    /**
     * Print a formatted info message to the logs, with an arbitrary number of
     * parameters.
     * 
     * @param message Message to be logged.
     * @param parameters Array of parameters.
     */
    public void info(String message, Object... parameters)
    {
        this.logger.info(message, parameters);
    }

    /**
     * Print an info message with an exception.
     * 
     * @param message Message to be logged.
     * @param throwable Throwable to be logged.
     */
    public void info(String message, Throwable throwable)
    {
        this.logger.info(message, throwable);
    }

    /**
     * Print a formatted info message to the logs, with an arbitrary number of
     * parameters and an exception.
     * <p/>
     * In order for this to work a workaround has to be done, because SLF4J's
     * api only allows for exceptions to be logged alongside with a String, thus
     * disabling formatted message AND exception logging.<br/>
     * Resorting to SLF4J's MessageFormater to format the message with the
     * parameters into a string and then passing that string as the message, it
     * is possible to have the best of both worlds.<br/>
     * In order to avoid incurring the overhead of this process, before doing
     * it, a test to check if the log level is enabled is done.
     * <p/>
     * NOTE: The order of the throwable and object array is switched due to Java
     * language limitations, but the exception always shows up AFTER the
     * formatted message.
     * 
     * @param message Message to be formatted.
     * @param throwable Throwable to be logged.
     * @param parameters Parameters to format the message.
     */
    public void info(String message, Throwable throwable, Object... parameters)
    {
        if (this.logger.isInfoEnabled())
        {
            this.logger.info(MessageFormatter.arrayFormat(message, parameters).getMessage(),
                throwable);
        }
    }

    /**
     * Test whether warn logging level is enabled.
     * 
     * @return <code>true</code> if warn logging level is enabled,
     *         <code>false</code> otherwise.
     */
    public boolean isWarnEnabled()
    {
        return this.logger.isWarnEnabled();
    }

    /**
     * Print a warning message to the logs.
     * 
     * @param message Message to be logged.
     */
    public void warn(String message)
    {
        this.logger.warn(message);
    }

    /**
     * Print a formatted warning message to the logs, with one parameter.
     * 
     * @param message Message to be logged.
     * @param parameter Message parameter.
     */
    public void warn(String message, Object parameter)
    {
        this.logger.warn(message, parameter);
    }

    /**
     * Print a formatted warning message to the logs, with an arbitrary number
     * of parameters.
     * 
     * @param message Message to be logged.
     * @param parameters Array of parameters.
     */
    public void warn(String message, Object... parameters)
    {
        this.logger.warn(message, parameters);
    }

    /**
     * Print a warning message with an exception.
     * 
     * @param message Message to be logged.
     * @param throwable Throwable to be logged.
     */
    public void warn(String message, Throwable throwable)
    {
        this.logger.warn(message, throwable);
    }

    /**
     * Print a formatted warn message to the logs, with an arbitrary number of
     * parameters and an exception.
     * <p/>
     * In order for this to work a workaround has to be done, because SLF4J's
     * api only allows for exceptions to be logged alongside with a String, thus
     * disabling formatted message AND exception logging.<br/>
     * Resorting to SLF4J's MessageFormater to format the message with the
     * parameters into a string and then passing that string as the message, it
     * is possible to have the best of both worlds.<br/>
     * In order to avoid incurring the overhead of this process, before doing
     * it, a test to check if the log level is enabled is done.
     * <p/>
     * NOTE: The order of the throwable and object array is switched due to Java
     * language limitations, but the exception always shows up AFTER the
     * formatted message.
     * 
     * @param message Message to be formatted.
     * @param throwable Throwable to be logged.
     * @param parameters Parameters to format the message.
     */
    public void warn(String message, Throwable throwable, Object... parameters)
    {
        if (this.logger.isWarnEnabled())
        {
            this.logger.warn(MessageFormatter.arrayFormat(message, parameters).getMessage(),
                throwable);
        }
    }

    /**
     * Test whether error logging level is enabled.
     * 
     * @return <code>true</code> if error logging level is enabled,
     *         <code>false</code> otherwise.
     */
    public boolean isErrorEnabled()
    {
        return this.logger.isErrorEnabled();
    }

    /**
     * Print an error message to the logs.
     * 
     * @param message Message to be logged.
     */
    public void error(String message)
    {
        this.logger.error(message);
    }

    /**
     * Print a formatted error message to the logs, with one parameter.
     * 
     * @param message Message to be logged.
     * @param parameter Message parameter.
     */
    public void error(String message, Object parameter)
    {
        this.logger.error(message, parameter);
    }

    /**
     * Print a formatted error message to the logs, with an arbitrary number of
     * parameters.
     * 
     * @param message Message to be logged.
     * @param parameters Array of parameters.
     */
    public void error(String message, Object... parameters)
    {
        this.logger.error(message, parameters);
    }

    /**
     * Print an error message with an exception.
     * 
     * @param message Message to be logged.
     * @param throwable Throwable to be logged.
     */
    public void error(String message, Throwable throwable)
    {
        this.logger.error(message, throwable);
    }

    /**
     * Print a formatted debug message to the logs, with an arbitrary number of
     * parameters and an exception.
     * <p/>
     * In order for this to work a workaround has to be done, because SLF4J's
     * api only allows for exceptions to be logged alongside with a String, thus
     * disabling formatted message AND exception logging.<br/>
     * Resorting to SLF4J's MessageFormater to format the message with the
     * parameters into a string and then passing that string as the message, it
     * is possible to have the best of both worlds.<br/>
     * In order to avoid incurring the overhead of this process, before doing
     * it, a test to check if the log level is enabled is done.
     * <p/>
     * NOTE: The order of the throwable and object array is switched due to Java
     * language limitations, but the exception always shows up AFTER the
     * formatted message.
     * 
     * @param message Message to be formatted.
     * @param throwable Throwable to be logged.
     * @param parameters Parameters to format the message.
     */
    public void error(String message, Throwable throwable, Object... parameters)
    {
        if (this.logger.isErrorEnabled())
        {
            this.logger.error(MessageFormatter.arrayFormat(message, parameters).getMessage(),
                throwable);
        }
    }
}
