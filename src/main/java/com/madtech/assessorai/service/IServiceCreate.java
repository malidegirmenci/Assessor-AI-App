package com.madtech.assessorai.service;

public interface IServiceCreate<T_Response, T_Request>{
    T_Response create(T_Request request);
}