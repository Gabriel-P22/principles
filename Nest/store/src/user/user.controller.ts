import { Body, Controller, Delete, Get, Param, Post, Put } from '@nestjs/common';
import { UserService } from './user.service';
import { UserDto } from './dto/user.dto';

@Controller('user')
export class UserController {
  constructor(private readonly userService: UserService) {}

  @Post()
    async createUser(@Body() body: UserDto) {
        const user = await this.userService.save(body);

        return {
          id: user.getId,
          message: "User created"
        };
    }

    @Get()
    async listUsers() {
        return this.listUsers();
    }

    @Put("/:id")
    async updateUser(@Param('id') id: string, @Body() body: UserDto) {
      const userUpdated = await this.userService.update(id, body);

      return {
        user: userUpdated,
        message: 'User updated with success'
      }
    }

    @Delete("/:id")
    async deleteUser(@Param("id") id: string) {
      await this.userService.remove(id)

      return {
        id: id,
        message: "removed"
      }
    }
}
