package app.revanced.patches.music.integration.discord

import app.revanced.patcher.data.BytecodeContext
import app.revanced.patcher.patch.BytecodePatch
import app.revanced.patcher.patch.PatchException
import app.revanced.patcher.patch.annotation.CompatiblePackage
import app.revanced.patcher.patch.annotation.Patch
import app.revanced.patches.music.integration.discord.fingerprints.AudioPlayerFingerprint

@Patch(
    name = "Discord Integration",
    description = "Adds Integration with Discord Rich Presence. Friends can view your current music as it's playing.",
    compatiblePackages = [CompatiblePackage("com.google.android.apps.youtube.music")],
)
@Suppress("unused")
object DiscordIntegrationPatch : BytecodePatch(
    setOf(AudioPlayerFingerprint)
) {
    override fun execute(context: BytecodeContext) {
        val result = AudioPlayerFingerprint.result
            ?: throw PatchException("AudioPlayerFingerprint not found")
        println("Found class: \n")
        result.classDef.methods.forEach{

        }
        println("${DiscordIntegrationPatch.name} is being executed.")
    }
}