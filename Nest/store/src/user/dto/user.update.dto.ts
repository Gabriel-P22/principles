import { IsEmail, IsNotEmpty, IsOptional, IsString, MinLength } from "class-validator";
import { EmailValidatorDecorator } from "../validations/email.validator";

export class UserUpdateDto {
    @IsString()
    @IsOptional()
    name: string;

    @IsEmail(undefined, { message: 'O e-mail é obrigatório' })
    @EmailValidatorDecorator({ message: "Use outro email" }) //custom
    @IsOptional()
    email: string;

    @MinLength(6)
    @IsOptional()
    password: string;
}