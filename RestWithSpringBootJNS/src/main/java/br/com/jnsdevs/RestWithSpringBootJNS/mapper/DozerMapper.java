package br.com.jnsdevs.RestWithSpringBootJNS.mapper;

//import com.github.dozermapper.core.DozerBeanMapperBuilder;
//import com.github.dozermapper.core.Mapper;

import java.util.ArrayList;
import java.util.List;

/**
 * @Autor Jairo Nascimento
 * @Created 13/08/2023 - 15:56
 */
public class DozerMapper {

//    private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();

//    public static <O, D> D parseObject(O origin, Class<D> destination) {
//        return mapper.map(origin, destination);
//    }

    public static <O, D> List<D> parseListObject(List<O> origin, Class<D> destination) {
        List<D> destinationObject = new ArrayList<D>();

//        for (O o : origin) {
//            destinationObject.add(mapper.map(o, destination));
//        }

        return destinationObject;
    }
}
