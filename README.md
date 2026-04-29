**This is strictly an adult oriented (18+) project.** 

I would like to warn people to stay away from **r/jennymod** (hxxps://www.reddit.com/r/jennymod), as the current moderation team apparently has something against freedom and transparent software? The ban reason: `mod stays dead`. Not informative or reasonable whatsoever.
My guess(es):
- They are trying to funnel everyone through their discord servers for ID / identity gathering (although they claim they do not keep info).
- Providing tracked links leading to the jar download (this is just a simple java program, take note...). This acts as a fingerprint, thus a tie to your real government identity.
- This approach in making it overly difficult to acquire a single .jar file, hints to me, that they are catering to a very specific (desperate) sect of users.
 - These users will not think twice about installing an inconspicious java program sourced from a Discord server.
 - These users dare not question what they are about to run on their host computer.

Silencing users for such minor acts insinuates a larger game at play here. I simply offered a solution for those who would like to add their own personalized features to the mod, at their own discretion. This behavior goes against several of my core beliefs, and I cannot act like it isn't a larger problem.

**You have been warned.**

---

I do not claim ownership over this mods source code or any affiliation with the original developers of this mod.

This is a reverse engineering project, with a main focus on Java obfuscation as documented below. 

All original audiovisual assets have been excluded to comply with legalities, Github TOS, etc...

# Jenny mod reverse engineering (TMC 1.1.0 version)

Created by Palkaline. I feel weird attaching this to my main, so...

I guess it makes sense to die as a corny side project!

## Features

Fully compiles without error and runs with 99% no bugs <sub>see notes below</sub>.

Project is in Gradle for Forge 1.12.2. This version is comparatively ancient when compared with everything newer. The support for this version is almost non-existent.

Migration to later versions will be very challenging. I am not a Forge dev, so the perceived work required is completely foreign to me... I already tried a bit of migration to 1.21.1 for the hell of it, and ran into a brick wall with the main class and proxy (I have no clue what I am doing with Forge).

Work-in-progress adapter for buttplug.io but not yet ported.

Forge SRG -> MCP mappings have been applied.

Only about 20% of all classes have been properly renamed to English. All other classes, fields, methods remain in their hard-to-read format (a.a), but everything resolves and compiles.

Geckolib is now required as a separate mod dependency if running in launcher / Forge.

## About

Initial goals of this project
- Reverse engineer the extreme obfuscation that has been applied jar-wide
- FOSS!

## Repeatability

If you want to reverse engineer the jar yourself, you'll need some tools. This isn't just something as simple as a Spigot plugin. It's a Forge mod. all usages of NMS have been converted to SRG mappings. On top of that is heavy obfuscation. 

Very. 
Heavy.
Obfuscation. 

But you want to anyways... huh? There are several layers:

1. Isolate TMC-specific code
   - Note the `only-TMC` postfix you will see in subsequent steps. I have decided for decompiler sanity, to isolate the packages to TMC only, because all other classes are shadowed and therefore, unmodified. 
   - Basically, isolation allows CFR to not attempt reversal or inference of the shadowed Geckolib as part of the decompilation. We instead will pass this as a classpath so it can use it as a reference for inheritance, etc... 
2. Run a special pre-deobfuscator. I call this "cleaning". Regardless of whatever decompiler / deobfuscator combo you eventually choose, you need somekind of pre-processor to prevent the decompiler from vomiting out garbage or having a stroke. This is **OPTIONAL** but **very highly recommended**.
    - This preprocessor takes a few hours to days to write, but run in a few seconds (3s)
    - I wrote my own pre-processor using object web asm library.
    - This step is intended to strip away as much obfuscation beforehand. You will have to identify bytecode for this step. Toss it into ChatGPT. It will tell you some things.
      - Remove excessive exception table patterns
      - Rename classes to reduce clashes between inner classes and fields
      - Heck, you can apply your own remapping from the Schnurri Jar if you wanted here!
      - By the final step, you will be left with valid, but hard to read code. So, try to do all the work beforehand in these important pre-steps.
3. Run CFR (or other decompiler with class-mapping)
    - This step takes up to a minute (60s)
      ```
      "Fapcraft 1.12.2 v1.1-only-TMC.jar-post.jar"
      --extraclasspath
      "/usr/lib/jvm/java-8-openjdk-amd64/jre/lib/rt.jar:~/.gradle/caches/minecraft/net/minecraftforge/forge/1.12.2-14.23.5.2847/stable/39/forge-1.12.2-14.23.5.2847-srgBin.jar:~/.gradle/caches/modules-2/files-2.1/software.bernie.geckolib/geckolib-forge-1.12.2/3.0.31/abab17e7e19cba9ab575425a32419eb9db9cb876/geckolib-forge-1.12.2-3.0.31.jar"
      --caseinsensitivefs
      true
      --removeinnerclasssynthetics
      false
      --antiobf
      true
      --tryresources
      false
      --renamedupmembers
      true
      --outputdir
      "java_TMC_clean"
      ```
4. Run a SRG -> MCP mapper (BON2) on all the .java files
    - This step takes a few seconds (3s).
    - I used some forked version of BON:
       ```
       --versionsJson "mcp-versions.json" --mappingsVer 1.12-stable_39 --input "java_TMC_clean/"
      ```
5. Manual editing
   - This is by far the longest step. Depending on what pre-processing and decompiler you decide on, this can range from a few hours to a few days. My final successful RE took like 8 hours of straight editing. I have envisioned a formula:
     - \frac{\sqrt[3]{x-6}}{4}+.46
     - You have a lot of determination at first. You have accepted the fact that a few hours must be sacrificed. As you reach hour 6, your chance of quitting has increased dramatically. Should you continue? Are you insane? Have you lost your mind?
     - If you are truly serious about this project, you must not look back. 
   - You are free to use all IDE plugins, heuristics, helpers, and even AI to assist you.
     - You will have to dig into bytecode if things are confusing. Try Fernflower first. Then try javap if still unclear:
       - `javap -c -p -l -s A_class1.class`

## Building and/or running

- This mod should compile without problems. 
  - Try the Gradle `build`
- Stock MC assets will not completely work due to the ancient Forge version during debugging.
  - They will likely work if running the mod in a normal forge install.
- If you want to run this project yourself, you must locate yourself the stock mod assets. 
  - <sub>If you have managed to reach this point... you know where to look...</sub>
  - then the `runClient`. If you did everything correctly, the mod assets should be visible in game.
  - I am not fully sure whether the mod will even compile, much less run without the assets... 
- Simply drag the original .jar assets to the resources/assets folder of this projects src folder, 
to match the original structure.

## Obfuscation

Ordered by severity
- exception pass-and-return wrapping
    ```
    try {
        // code ...
    } catch (RuntimeException runtimeException) {
        // see here... exceptions are wrapped, passed, and returned (identity)
        throw a(new RuntimeException(runtimeException));
    }
    
    public static RuntimeException a(RuntimeException runtimeException) {
        return runtimeException;
    }
    ```

- exception table mashing
    ```
    try {
        try {
            try {
                // ... real code
            } catch (RuntimeException runtimeException) {
                throw a(new RuntimeException(runtimeException));
            }
            // code ... or fallthrough
        } catch (RuntimeException runtimeException) {
            throw a(new RuntimeException(runtimeException));
        }
        // code ... or fallthrough
    } catch (RuntimeException runtimeException) {
        throw a(new RuntimeException(runtimeException));
    }
    ```
- dangling catch blocks
    ```
    int a = 5 + z;
    // some code ...
    catch { // dangling catch without prior try
        throw a.b(new RuntimeException());
    }
    ```
- impossible control flow
    ```
    block71: {
        block73: {
            block75: {
                // some code...
                *** goto label69 *** // impossible to track
            }
        }
    }
    ```
- local reuse
    ```
    Object z = new Integer(5);
    // some code...
    z = new HashMap<Integer, Double>();
    ```
- duplicate identifiers
    ```
    class a {
        int a;
        Aa a;
        A a();
        public class a {
        
        }
    }
    ```
- synthetic(s) <sub>deserves a whole subtopic of its own</sub>
  - generic "fill-all" wrappers
  - inner class helpers
- generic stripping
  - `class A<B>` --> `class A`, across classes, methods, params...
- clashing signature
    ``` 
    int a()
    
    float a()
    
    a a()
    ```
- Other CFR failures not included above...

## Regex

Useful patterns below:

- Generic stripped onMessage repopulation:
  - Find: `((?:public|protected|private)?\s*IMessage\s+onMessage\s*\(\s*)IMessage(\s+\w+\s*,\s*MessageContext\s+\w+\s*\)\s*\{\s*return\s+[\w.]+\s*\(\s*\(\s*)([\w.]+)(\s*\)\s*\w+\s*,\s*\w+\s*\)\s*;\s*\})`
  - Replace: `@Override\n$1$3$2$3$4`
- Finding calls to arbitrary method, ie `ad`:
  - `(void |\.)ad\(\)`
- <details>
  <summary>Finding censored words:</summary>
  
    ```
    cock|pussy|dick|sex|trol|(?<!cl)ass|anal|butt|booty|sex|jenny|girl|nude|bee|ellie|slime|galath|fap
    ```
  </details>

No longer needed: 
- Exception wrapping obfuscation (pass-and-return)
    - Find: `throw ([\w\d]+)\.([\w\d]+)\(([\w\d]+)\);`
    - Replace: `throw $3;`

## Bugs

I 110% guarantee there are bugs that were created during the deobfuscation process. Many steps are likely to result in many bugs, with each step compounding bugs before them.

The most likely bugs are:
- Dangling overrides I failed to rename 
  - a to doRender, getResourceLocation, getTexture, getModelFileLocation
  - so, these might fallback to defaults from the parent class.
- Referencing incorrect method, same signature.
  - Static method resolution is strange to me... you learn something new!

## Modifications from source jar

- I have edited some code portions that I believe are a bit anti-user:
  - The mod .jar and cwd deletion in /mods when age check fails
    - Filesystem manipulation seems dangerous to me
    - I find this check screen to be quite a bit ugly (javax...), I swear there used to 
    be an embedded in-game age-ask GUI button(s)... maybe I am too old...
- Commenting out of broken code:
  - An example is in the Kobold Damage Listener
    - It prints out tribe stats when a hit is registered. This however seems
    broken in its current state.
- Other things I've probably forgotten... have been commented out though.

## TODO

- fix broken refactors
  - see above...
- add buttplug.io support and/or proper keyframing to animations to resolve motion
  - see TODOs (search 'toy' etc...)
  - I wrote a tiny proof-of-concept (not pictured in this project) that I managed to get working, 
  but it requires manual copying / pasting across each entity. I hate the design of this project.
  I feel like there is a better supported way to implement this... again, see comments...
  
## References

- See: https://github.com/hfgufjkgjkfbg/Minecraft-Sex-Mod-Jenny-1.12.2-Forge
