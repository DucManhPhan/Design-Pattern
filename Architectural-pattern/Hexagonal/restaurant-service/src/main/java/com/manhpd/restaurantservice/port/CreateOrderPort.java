package com.manhpd.restaurantservice.port;

import com.manhpd.restaurantservice.port.dto.InputDto;
import com.manhpd.restaurantservice.port.dto.OutputDto;

public interface CreateOrderPort {
    OutputDto createOrderPort(InputDto dto);
}
