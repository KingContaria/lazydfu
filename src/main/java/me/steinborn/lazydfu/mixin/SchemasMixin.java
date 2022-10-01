package me.steinborn.lazydfu.mixin;

import com.mojang.datafixers.DataFixerBuilder;
import me.steinborn.lazydfu.mod.LazyDataFixerBuilder;
import net.minecraft.class_2935;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(class_2935.class)
public class SchemasMixin {

    @Redirect(method = "method_21534", at = @At(value = "NEW", target = "com/mojang/datafixers/DataFixerBuilder"))
    private static DataFixerBuilder create$replaceBuilder(int dataVersion) {
        return new LazyDataFixerBuilder(dataVersion);
    }
}