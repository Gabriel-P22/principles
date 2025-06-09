import { Injectable } from "@nestjs/common";

export interface UserI {
    name: string
}

@Injectable()
export class UserRepository {
    private users: UserI[] = [];

    async save(user) {
        this.users.push(user);

        console.log(this.users)
    }

    async getAll() {
        return this.users;
    }

}