package app.revanced.patches.music.integration.discord.fingerprints

import app.revanced.patcher.extensions.or
import app.revanced.patcher.fingerprint.MethodFingerprint
import app.revanced.patcher.fingerprint.annotation.FuzzyPatternScanMethod
import com.android.tools.smali.dexlib2.AccessFlags
import com.android.tools.smali.dexlib2.Opcode

// Finding method "P" in Class "aoik" in Youtube Music Build 6.29.57 for armv8
//@FuzzyPatternScanMethod(2) // FIXME: Test this threshold and find the best value.
internal object AudioPlayerFingerprint : MethodFingerprint(
    returnType = "V",
    accessFlags = AccessFlags.PUBLIC or AccessFlags.FINAL,
    parameters = listOf("J", "I"),
    opcodes = listOf(
        Opcode.CONST_WIDE_32,
        Opcode.CMP_LONG,
        Opcode.IF_GTZ,
        Opcode.CONST_WIDE_32,
        Opcode.CMP_LONG,
        Opcode.IF_GEZ,
        Opcode.GOTO,
        Opcode.SGET,
        Opcode.CONST_16,
        Opcode.IF_LT,
        Opcode.ADD_INT_LIT8,
        Opcode.PACKED_SWITCH,
        Opcode.LONG_TO_INT,
        Opcode.IGET_OBJECT,
        Opcode.INVOKE_VIRTUAL,
        Opcode.RETURN_VOID,
        Opcode.IGET_OBJECT,
        Opcode.CONST_4,
        Opcode.INVOKE_VIRTUAL,
        Opcode.RETURN_VOID,
        Opcode.IGET_OBJECT,
        Opcode.CONST_4,
        Opcode.INVOKE_VIRTUAL,
        Opcode.RETURN_VOID,
        Opcode.IGET_OBJECT,
        Opcode.CONST_4,
        Opcode.INVOKE_VIRTUAL,
        Opcode.RETURN_VOID,
        Opcode.IGET_OBJECT,
        Opcode.CONST_4,
        Opcode.INVOKE_VIRTUAL,
        Opcode.RETURN_VOID,
        Opcode.LONG_TO_INT,
        Opcode.IGET_OBJECT,
        Opcode.INVOKE_VIRTUAL,
        Opcode.RETURN_VOID,
        Opcode.SGET_OBJECT,
        Opcode.SGET_OBJECT,
        Opcode.CONST_STRING,
        Opcode.CONST_STRING,
        Opcode.INVOKE_STATIC,
        Opcode.MOVE_RESULT_OBJECT,
        Opcode.INVOKE_STATIC,
        Opcode.RETURN_VOID,
        ),
    strings = listOf("32 bit integer overflow attempting to seekTo: ")
)