package SetupEnv;

import org.apache.logging.log4j.LogManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by root on 1/10/17.
 */
public class TaskManager {

    private static org.apache.logging.log4j.Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    public static void startTasks(Arguments arguments, Map<String, DeviceData> topologyMap){
        List<RunnableTask> threadList = new ArrayList<RunnableTask>();

        logger.info("Creating thread instance.");
        for (Map.Entry<String, DeviceData> e: topologyMap.entrySet()){
            threadList.add(new RunnableTask(e.getKey().toString(), e.getValue()));
            logger.debug("The instance for \""+e.getKey()+"\" has been created.");
        }

        logger.info("Start all the threads.");
        for (RunnableTask task: threadList){
            task.start();
        }

        logger.debug("Wait for the threads.");
        for (RunnableTask task: threadList){
            task.join();
        }
    }


}
