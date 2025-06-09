import { IsEmail, IsNotEmpty, IsString, MinLength } from "class-validator";

export class UserDto {

    @IsString()
    @IsNotEmpty({ message: 'O name é obrigatório' })
    name: string;

    @IsEmail(undefined, { message: 'O e-mail é obrigatório' })
    @IsNotEmpty({ message: 'O e-mail é obrigatório' })
    email: string;

    @MinLength(6)
    @IsNotEmpty({ message: 'A senha é obrigatório' })
    senha: string;
}