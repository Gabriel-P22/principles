import { Body, Get, Injectable, Post } from '@nestjs/common';
import { UserI, UserRepository } from './user.repository';

@Injectable()
export class UserService {

    constructor(private userRepository: UserRepository) {}

    @Post()
    async createUser(@Body() body: UserI) {
        this.userRepository.save(body);

        return body;
    }

    @Get()
    async listUsers() {
        return this.listUsers();
    }
}
