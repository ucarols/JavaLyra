package com.example.lyra.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DailyCheckInRequest {
    
    @Min(value = 1, message = "O humor deve ser entre 1 e 5")
    @Max(value = 5, message = "O humor deve ser entre 1 e 5")
    private Integer humor; // 1-5 (Ótimo a Terrível)
    
    @Min(value = 0, message = "O sono não pode ser negativo")
    @Max(value = 24, message = "O sono não pode ser maior que 24 horas")
    private Integer sono; // Horas de sono
    
    @Min(value = 0, message = "A hidratação não pode ser negativa")
    @Max(value = 8, message = "A hidratação não pode ser maior que 8 copos")
    private Integer hidratacao; // Copos de água (máximo 8)
}
