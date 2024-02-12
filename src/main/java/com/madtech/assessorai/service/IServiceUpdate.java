package com.madtech.assessorai.service;

public interface IServiceUpdate<T_Response, T_Request> {
    T_Response update(long id, T_Request request);
}
