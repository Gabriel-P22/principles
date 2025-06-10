import { Injectable } from '@nestjs/common';
import { UserRepository } from './user.repository';
import { UserEntity } from './entity/user.entity';
import { v4 as uuid } from 'uuid';
import { UserDto } from './dto/user.dto';
import { UserResponse } from './dto/user-response.dto';

@Injectable()
export class UserService {
    constructor(private userRepository: UserRepository) {}

    async save(user: UserDto): Promise<UserEntity> {
        const entity = new UserEntity(
            uuid(),
            user.name,
            user.email,
            user.password
        );

        this.userRepository.users.push();

        return entity;
    }

    async getAll(): Promise<UserResponse[]> { 
        return this.userRepository.users.map((u) => new UserResponse(u.getId, u.getName));
    }

    async update(id: string, entity: Partial<UserEntity>) {
        const possibleUser = this.userRepository.findUser(id);

        if (!possibleUser) {
            throw new Error("user not found")
        }

        this.userRepository.updateUser(entity);

        return possibleUser;
    }

    async remove(id: string) {
        await this.userRepository.remove(id)
    }
}
