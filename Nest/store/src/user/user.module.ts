import { Module } from '@nestjs/common';
import { UserService } from './user.service';
import { UserController } from './user.controller';
import { UserRepository } from './user.repository';
import { EmailValidator } from './validations/email.validator';


@Module({
  controllers: [UserController],
  providers: [UserService, UserService, UserRepository, EmailValidator],
})
export class UserModule {}
