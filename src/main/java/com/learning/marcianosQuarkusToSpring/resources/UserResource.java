package com.learning.marcianosQuarkusToSpring.resources;


import com.learning.marcianosQuarkusToSpring.model.Conta;
import com.learning.marcianosQuarkusToSpring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/users")
@RequiredArgsConstructor
public class UserResource {

    private final UserService service;

//    @GetMapping(path="/contas")
//    public ResponseEntity listContas() {
//        Conta conta = service.getContas().get(0);
//        return ResponseEntity.ok().build();
//    }


    @PostMapping("/contas")
    public ResponseEntity saveConta() {

        Conta conta = new Conta();
        conta.setNumero((int) (Math.random() * 10));
        conta.setTitular(service.getAll().get(0));


        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.saveConta(conta));
    }

    //
    @GetMapping
    public ResponseEntity listAllUsers() {

        return ResponseEntity.ok(service.getAll());
    }
//
//    @POST
//    @Transactional
//    public Response saveUser(UserRequest dto) {
//
//        Set<ConstraintViolation<UserRequest>> constraintViolationSet = validator.validate(dto);
//
//        if (constraintViolationSet.isEmpty()) {
//            return Response
//                    .status(Response.Status.CREATED)
//                    .entity(service.save(dto))
//                    .build();
//        } else {
//           // ConstraintViolation<UserRequest> constraintViolation = constraintViolationSet.stream().findFirst().get();
//
//            ResponseError responseError = ResponseError.createFrom(constraintViolationSet);
//
//            return Response
//                    .status(Response.Status.BAD_REQUEST)
//                    .entity(responseError)
//                    .build();
//        }
//    }
//
//    @DELETE
//    @Path("{id}")
//    @Transactional
//    public Response deleteUser(@PathParam("id") Long id) {
//
//        if (service.delete(id)) {
//
//            return Response.accepted().build();
//
//        } else {
//            return Response.status(Response.Status.NOT_FOUND).build();
//        }
//    }
//
//    @PUT
//    @Path("{id}")
//    @Transactional
//    public Response updateUser(@PathParam("id") Long id, UserRequest dto) {
//
//
//        var optionalUser = service.update(id, dto);
//
//        if (optionalUser.isPresent()) {
//
//            return Response.accepted(optionalUser.get()).build();
//        } else {
//
//            return Response.status(Response.Status.NOT_FOUND).build();
//        }

}
