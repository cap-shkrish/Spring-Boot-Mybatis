package Processor;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
	
	private final Logger logger =  LoggerFactory.getLogger(getClass());
	
	@Nullable
	public Object postProcessBeforeInitialization(Object bean, String beanName)
	throws BeansException
	{
		logger.info("----> Before " + bean.getClass());
		return bean;
	}

	@Nullable
	public Object postProcessAfterInitialization(Object bean, String beanName)
	throws BeansException
	{
		logger.info("----> After " + bean.getClass());
		return bean;
	}

}
