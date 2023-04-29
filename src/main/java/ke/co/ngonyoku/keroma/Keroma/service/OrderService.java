package ke.co.ngonyoku.keroma.Keroma.service;

import jakarta.persistence.EntityNotFoundException;
import ke.co.ngonyoku.keroma.Keroma.model.Order;
import ke.co.ngonyoku.keroma.Keroma.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Order not found with id: " + id));
    }

    public List<Order> getOrdersByUserId(Long userId) {
        return orderRepository.findByUser_Id(userId);
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order updateOrder(Order order) {
        if (!orderRepository.existsById(order.getId())) {
            throw new EntityNotFoundException("Order not found with id: " + order.getId());
        }
        return orderRepository.save(order);
    }

    public void deleteOrder(Long id) {
        if (!orderRepository.existsById(id)) {
            throw new EntityNotFoundException("Order not found with id: " + id);
        }
        orderRepository.deleteById(id);
    }
}
