package mindera.mindswap.aveiro.module2.springboot.myfirstapi.converter;

public interface Converter<U,T> {

    T convertToDto(U u);
    U convertFromDto(T t);
}
