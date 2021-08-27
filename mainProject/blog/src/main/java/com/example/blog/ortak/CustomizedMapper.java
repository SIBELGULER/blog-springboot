package com.example.blog.ortak;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;


@Component
public class CustomizedMapper extends ModelMapper {

    @Override
    public <D> D map(Object source, Type destinationType) {
        if (source == null) {
            return null;
        } else {
            return super.map(source, destinationType);
        }
    }

    @Override
    public <D> D map(Object source, Class<D> destinationType) {
        if (source == null) {
            return null;
        } else {
            return super.map(source, destinationType);
        }
    }

}
