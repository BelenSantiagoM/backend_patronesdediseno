package abstractFactory

import properties.PropertiesUtil.loadProperty
import kotlin.reflect.full.createInstance

abstract class ServiceStackAbstractFactory{
    companion object{
        fun createServiceFactory(): IServiceStackAbstractFactory?{
            val property = loadProperty(
                    "properties/abstractfactory"
            )
            val factoryClass = property!!.getProperty("serviceProductImplClass")
            return try {
                Class.forName(factoryClass).kotlin.createInstance() as IServiceStackAbstractFactory
            }catch (e: Exception){
                e.printStackTrace()
                null
            }
        }
    }
}