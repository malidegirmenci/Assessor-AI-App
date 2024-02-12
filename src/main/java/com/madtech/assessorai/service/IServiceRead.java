package com.madtech.assessorai.service;

import java.util.List;

public interface IServiceRead <T_Response> {
    T_Response readById(long id);
    List<T_Response> readAll();
}
