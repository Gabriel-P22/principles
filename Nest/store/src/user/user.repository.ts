import { Injectable } from "@nestjs/common";
import { UserEntity } from "./entity/user.entity";


@Injectable()
export class UserRepository {
    public users: UserEntity[] = [];

    async hasEmail(email: string) {
        const user = this.users.find(user => user.getEmail === email);
        return user !== undefined;
    }

    async findUser(userId) {
        return this.users.find(
            user => user.getId === userId
        )
    }

    async updateUser(userEntity: Partial<UserEntity>) {
        Object.entries(userEntity).forEach(([ key, value ]) => {
            if (key === 'id') { return }

            userEntity[key] = value
        })
    }
}