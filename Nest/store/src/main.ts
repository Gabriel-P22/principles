import { NestFactory } from '@nestjs/core';
import { AppModule } from './app.module';
import { ValidationPipe } from '@nestjs/common';

async function bootstrap() {
  const app = await NestFactory.create(AppModule);
  app.useGlobalPipes(
    new ValidationPipe({
      transform: true, // Permite transformar em objetos
      whitelist: true, // Vai ignorar todos os campos que não estão presentes no dto
      forbidNonWhitelisted: true // Lança um erro quando recebe um valor que não estava presente no dto
    })
  );
  await app.listen(process.env.PORT ?? 3000);
}
bootstrap();
