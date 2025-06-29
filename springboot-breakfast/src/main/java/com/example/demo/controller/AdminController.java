package com.example.demo.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.dto.AdminDto;
import com.example.demo.model.dto.OrderTableDto;
import com.example.demo.model.dto.orderDto;
import com.example.demo.model.entity.OrderTable;
import com.example.demo.repository.OrderTableRepository;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:5173/", allowCredentials = "true" )   // 允許跨域
public class AdminController {

	@Autowired
	OrderTableRepository orderTableRepository;
	
	// 得到所有訂單
	@GetMapping("/orders")
	public ResponseEntity<List<AdminDto>> getAllOrders() {
	    List<OrderTable> orderList = orderTableRepository.findAll();
	
	    List<AdminDto> dtos = orderList.stream().map(order -> {
	        AdminDto dto = new AdminDto();
	        dto.setUserName(order.getUser().getUserName());
	        dto.setOrderId(order.getOrderId());
	        dto.setOrderItems(order.getOrderItems());
	        dto.setTotalPrice(order.getTotalPrice());
	        dto.setNote(order.getNote());
	        dto.setOrderTime(order.getOrderTime());
	        return dto;
	    }).collect(Collectors.toList());
	
	    return ResponseEntity.ok(dtos);
	}
	
	// 修改訂單
    @PutMapping("/orders/{orderId}")
    public ResponseEntity<String> updateOrder(@PathVariable Integer orderId,
                                               @RequestBody OrderTableDto updateDto) {
        Optional<OrderTable> optionalOrder = orderTableRepository.findById(orderId);
        if (optionalOrder.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        OrderTable order = optionalOrder.get();

        if (!order.getOrderItems().isEmpty()) {
            order.getOrderItems().get(0).setQuantity(updateDto.getQuantity());
        }
        order.setOrderTime(updateDto.getOrderTime());

        orderTableRepository.save(order);
        return ResponseEntity.ok("Order updated successfully");
    }
    
    // 刪除訂單
    @DeleteMapping("/orders/{orderId}")
    public ResponseEntity<String> deleteOrder(@PathVariable Integer orderId) {
        if (!orderTableRepository.existsById(orderId)) {
            return ResponseEntity.notFound().build();
        }

        orderTableRepository.deleteById(orderId);
        return ResponseEntity.ok("Order deleted successfully");
    }
	
}
