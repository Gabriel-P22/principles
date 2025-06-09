
export class UserEntity {
    private id: string;
    private name: string;
    private email: string;
    private password: string;

    constructor(id: string, name: string, email: string, password: string) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    get getEmail() {
        return this.email
    }

    get getId () {
        return this.id
    }

     get getName () {
        return this.name
    }
}